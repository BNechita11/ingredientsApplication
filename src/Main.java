import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Introducerea numelui rețetei
        System.out.println("Introduceți numele rețetei:");
        String numeReteta = scanner.nextLine();

        // Crearea listei de ingrediente pentru rețeta
        List<Ingredient> ingredienteReteta = new ArrayList<>();

        while (true) {
            // Introducerea numelui ingredientului
            System.out.println("Introduceți numele ingredientului sau 'gata' pentru a termina:");
            String numeIngredient = scanner.nextLine();

            if (numeIngredient.equalsIgnoreCase("gata")) {
                break;
            }

            // Verificarea tipului de ingredient și crearea corespunzătoare
            System.out.println("Este ingredientul simplu sau compus? (simplu/compus)");
            String tipIngredient = scanner.nextLine();

            if (tipIngredient.equalsIgnoreCase("simplu")) {
                ingredienteReteta.add(new IngredientSimplu(numeIngredient));
            } else if (tipIngredient.equalsIgnoreCase("compus")) {
                // Introducerea ingredientelor simple pentru ingredientul compus
                List<IngredientSimplu> ingredienteSimpleCompus = new ArrayList<>();
                while (true) {
                    System.out.println("Introduceți numele ingredientului simplu pentru ingredientul compus sau 'gata' pentru a termina:");
                    String numeIngredientSimplu = scanner.nextLine();

                    if (numeIngredientSimplu.equalsIgnoreCase("gata")) {
                        break;
                    }
                    ingredienteSimpleCompus.add(new IngredientSimplu(numeIngredientSimplu));
                }
                ingredienteReteta.add(new IngredientCompus(numeIngredient, ingredienteSimpleCompus));
            } else {
                System.out.println("Tip de ingredient necunoscut.");
            }
        }

        // Crearea rețetei
        Reteta reteta = new Reteta(numeReteta, ingredienteReteta);
        List<Reteta> listaRetete = new ArrayList<>();
        listaRetete.add(reteta);

        // Afisare nume rețetă
        System.out.println("Numele rețetei: " + reteta.getNume());

        // Afisare ingrediente rețetă
        System.out.println("Ingrediente rețetă:");
        for (Ingredient ingredient : reteta.getIngrediente()) {
            if (ingredient instanceof IngredientSimplu) {
                System.out.println("- Ingredient simplu-simplu: " + ((IngredientSimplu) ingredient).getDenumire());
            } else if (ingredient instanceof IngredientCompus) {
                System.out.println("- Ingredient compus: " + ((IngredientCompus) ingredient).getDenumire());
                System.out.println("  Ingrediente simple:");
                for (IngredientSimplu ingredientSimplu : ((IngredientCompus) ingredient).getIngredienteSimple()) {
                    System.out.println("    - " + ingredientSimplu.getDenumire());
                }
            }
        }

        // Afișare listă de apariții unice a ingredientelor simple (cerinta1)
        reteta.afiseazaIngredienteSimpleUnice();

        // Introducerea ingredientului simplu pentru a căuta rețetele în care apare
        System.out.println("Introduceți numele ingredientului simplu pentru a căuta rețetele în care apare:");
        String ingredientCautat = scanner.nextLine();

        // Afișare rețetele în care apare ingredientul simplu dat(cerinta2)

        System.out.println("Rețetele în care apare ingredientul simplu '" + ingredientCautat + "':");
        for (Reteta r : listaRetete) {
            if (r.contineIngredientSimplu(ingredientCautat)) {
                System.out.println("- " + r.getNume());
            }
            else {
                System.out.println("Nu ati folosit acest ingredient in nicio reteta!");
            }
        }
    }
}