public class MaterialType {
    private String name;
    private String description;
    private Double priceForOneGram;

    public MaterialType(String name, String description, Double priceForOneGram) {
        this.name = name;
        this.description = description;
        this.priceForOneGram = priceForOneGram;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) throw new NullPointerException("Material name cannot be null");
        this.name = name;

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null) throw new NullPointerException("description cannot be null");
        this.description = description;

    }

    public Double getPriceForOneGram() {
        return priceForOneGram;
    }

    public void setPriceForOneGram(Double priceForOneGram) {
        if (priceForOneGram == null || priceForOneGram==0.0) throw new NullPointerException("price cannot be null or equals to 0");
        this.priceForOneGram = priceForOneGram;

    }
}
