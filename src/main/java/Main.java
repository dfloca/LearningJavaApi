import API.API;
import API.Printer;
import com.google.gson.Gson;
import org.apache.http.client.methods.HttpGet;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String command = "";
        String query = "";
        showHelp();

        while(!command.equalsIgnoreCase("q")) {
            System.out.println("Awaiting input...");
            command = reader.nextLine();

            //the program manual
            if (command.equalsIgnoreCase("h")) {
                showHelp();
            }
            else if (command.equalsIgnoreCase("t")) {
                System.out.println("Enter a title to search by:");
            }
            else if (command.equalsIgnoreCase("p")) {
                System.out.println("Enter a planet to search by:");
            }
            else if (command.equalsIgnoreCase("s")) {
                System.out.println("Enter a starship to search by:");
            }
            else if (command.equalsIgnoreCase("q")) {
                return;
            }

            query = reader.nextLine();

            // build request URL (as a String) in the method defined below

            // build HttpGet request using the request URL

            // initiate API request getRequest(HttpGet getRequest), which returns a JsonObject response
            // the API is provided for you
            API api = new API();

            // put response results into a JsonArray

            // you can test your output by using the Printer object
            // use printer.printDetailsFilms(), printer.printDetailsPlanets(), printer.printDetailsStarships()
            // based on the type of request that was made
            Printer printer = new Printer();

            /**
             * Now we want to put our results into objects to make them easier to work with.
             *  Film()
             *      string title
             *      int episode_id
             *      string opening_crawl
             *      string director
             *      string producer
             *      string release_date
             *      List<String> characters
             *      List<String> planets
             *      List<String> starships
             *      List<String> vehicles
             *      List<String> species
             *      string created
             *      string edited
             *      string url
             *
             *      toString()
             *
             *  For now, we will only get the urls for characters, planets, starships, vehicles, and species
             *  If you have extra time, you can figure out how to populate them with actual data
             *      - you can find definitions of the objects here: https://swapi.dev/documentation#java
             *      - you can find how to make subrequests on the urls in Printer
             *
             *  Starship()
             *      string name
             *      string model
             *      string manufacturer
             *      string cost_in_credits
             *      string length
             *      string max_atmosphering_soeed
             *      string crew
             *      string passengers
             *      string cargo_capacity
             *      string consumables
             *      string hyperdrive_rating
             *      string MGLT
             *      string starship_class
             *      List<String> pilots
             *      List<String> films
             *      string created
             *      string edited
             *      string url
             *
             *      toString()
             *
             *  Planet()
             *      string name
             *      string rotation_period
             *      string orbital_period
             *      string diameter
             *      string climate
             *      string gravity
             *      string terrain
             *      string surface_water
             *      string population
             *      List<String> residents
             *      List<String> films
             *      string created
             *      string edited
             *      string url
             *
             *      toString()
             */

            // use Gson to turn your JsonObject into a Film, Starship, or Planet object (based on the previously selected user command)
            // https://stackoverflow.com/a/27633777/7748295
            Gson gson = new Gson();

            // output the object using toString()

        }
    }

    /**
     * baseUrl = "https://swapi.dev/api/"
     * Search for films: "https://swapi.dev/api/films/?search=user_input"
     * Search for planets: "https://swapi.dev/api/planets/?search=user_input"
     * Search for starships: "https://swapi.dev/api/starships/?search=user_input"
     * */
    public static String buildRequestUrl(String command, String searchQuery) {
        String baseUrl = "https://swapi.dev/api/";

        // sanitize the query in case there are spaces in the string. spaces will break the request, so change them to '%20'
        searchQuery = sanitizeSearchQuery(searchQuery);


        return baseUrl;
    }

    private static String sanitizeSearchQuery(String searchQuery) {
        return searchQuery.replaceAll(" ", "%20");
    }

    public static void showHelp() {
        System.out.println("To search by title, enter \"t\"");
        System.out.println("To search by planet, enter \"p\"");
        System.out.println("To search by starship, enter \"s\"");
        System.out.println("To show this help menu again, enter \"h\"");
        System.out.println("To quit the program, enter \"q\"");
    }
}
