import java.util.List;
import java.util.Objects;

public class IngredientCompus implements Ingredient {
    private String denumire;
    private List<IngredientSimplu> ingredienteSimple;

    public IngredientCompus(String denumire, List<IngredientSimplu> ingredienteSimple) {
        this.denumire = denumire;
        this.ingredienteSimple = ingredienteSimple;
    }

    public String getDenumire() {
        return denumire;
    }

    public List<IngredientSimplu> getIngredienteSimple() {
        return ingredienteSimple;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        IngredientCompus that = (IngredientCompus) obj;
        return denumire.equals(that.denumire) &&
                ingredienteSimple.equals(that.ingredienteSimple);
    }

    @Override
    public int hashCode() {
        return Objects.hash(denumire, ingredienteSimple);
    }
   // Suprascrie metodele equals() și hashCode() pentru a permite comparația și utilizarea
    // obiectelor de tip IngredientCompus în colecții.
}
