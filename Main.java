import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws Exception {

        // fazer uma conexão HTTP e buscar os top 250 filmes
        String url = "https://api.themoviedb.org/3/trending/movie/week?api_key=872995efee79646f5b0d834c33522673";
        URI endereco = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        System.out.println(body);

        //extrair/parsear os dados que interessam (titulo, poster, classificaçao)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        // exibir e manipular os dados
        for (Map<String,String> filme : listaDeFilmes) {

            System.out.println(filme.get("title"));
            System.out.println(filme.get("backdrop_path"));
            System.out.println(filme.get("vote_average"));
            //desafio 2 - deixar  mais bonitinho
            System.out.println("\u001b[1m Relex, cafézim e bom filmim! ");
            System.out.println("✌ " + "☕");
            System.out.println("✌ " + "☕");
            //desafio 5 criar alguma maneira para você dar uma avaliação ao filme, puxando de algum arquivo de configuração OU pedindo a avaliação para o usuário digitar no terminal.
            System.out.println("O que achou do filme? ");
            Scanner sc = new Scanner(System.in);
            String opiniao = sc.nextLine();
            System.out.println("Sua resposta: "+ opiniao);
            System.out.println();
        }

    }
}