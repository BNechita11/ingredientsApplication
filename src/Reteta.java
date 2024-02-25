import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Reteta {
    private String nume;
    private List<Ingredient> ingrediente;

    public Reteta(String nume, List<Ingredient> ingrediente) {
        this.nume = nume;
        this.ingrediente = ingrediente;
    }

    public String getNume() {
        return nume;
    }

    public List<Ingredient> getIngrediente() {
        return ingrediente;
    }

    public Set<IngredientSimplu> getIngredienteSimpleUnice() {
        Set<IngredientSimplu> ingredienteUnice = new HashSet<>();
        for (Ingredient ingredient : ingrediente) {
            if (ingredient instanceof IngredientSimplu) {
                ingredienteUnice.add((IngredientSimplu) ingredient);
            } else if (ingredient instanceof IngredientCompus) {
                ingredienteUnice.addAll(((IngredientCompus) ingredient).getIngredienteSimple());
            }
        }
        return ingredienteUnice;
    }

    public void afiseazaIngredienteSimpleUnice() {
        Set<IngredientSimplu> ingredienteUnice = getIngredienteSimpleUnice();
        System.out.println("Ingrediente simple unice în rețeta " + getNume() + ":");
        for (IngredientSimplu ingredient : ingredienteUnice) {
            System.out.println("- " + ingredient.getDenumire());
        }
    }

    public boolean contineIngredientSimplu(String numeIngredient) {
        for (Ingredient ingredient : ingrediente) {
            if (ingredient instanceof IngredientSimplu) {
                if (((IngredientSimplu) ingredient).getDenumire().equalsIgnoreCase(numeIngredient)) {
                    return true;
                }
            } else if (ingredient instanceof IngredientCompus) {
                for (IngredientSimplu ingredientSimplu : ((IngredientCompus) ingredient).getIngredienteSimple()) {
                    if (ingredientSimplu.getDenumire().equalsIgnoreCase(numeIngredient)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

