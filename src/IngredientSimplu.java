import java.util.Objects;

public class IngredientSimplu implements Ingredient {
    private String denumire;

    public IngredientSimplu(String denumire) {
        this.denumire = denumire;
    }

    public String getDenumire() {
        return denumire;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        IngredientSimplu that = (IngredientSimplu) obj;
        return denumire.equals(that.denumire);
    }

    @Override
    public int hashCode() {
        return Objects.hash(denumire);
    }

    //Am suprascris metodele equals() și hashCode() pentru a permite comparația și
    // utilizarea obiectelor de tip IngredientSimplu în colecții, cum ar fi HashSet
}
