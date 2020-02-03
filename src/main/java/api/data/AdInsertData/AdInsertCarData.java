package api.data.AdInsertData;

public class AdInsertCarData extends AdInsertBase {
    private String
        marque,
        model,
        carburant,
        km,
        anneeImmatriculation;

    public AdInsertCarData(String marque, String model, String carburant, String km, String anneeImmatriculation) {
        this.marque = marque;
        this.model = model;
        this.carburant = carburant;
        this.km = km;
        this.anneeImmatriculation = anneeImmatriculation;
    }

    public AdInsertCarData(AdInsertBase adInsertBase, String marque, String model, String carburant, String km, String anneeImmatriculation) {
        super(adInsertBase.subject, adInsertBase.body, adInsertBase.price, adInsertBase.cityWording, adInsertBase.secteur, adInsertBase.name, adInsertBase.email, adInsertBase.emailNu, adInsertBase.phone, adInsertBase.password);
        this.marque = marque;
        this.model = model;
        this.carburant = carburant;
        this.km = km;
        this.anneeImmatriculation = anneeImmatriculation;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCarburant() {
        return carburant;
    }

    public void setCarburant(String carburant) {
        this.carburant = carburant;
    }

    public String getKm() {
        return km;
    }

    public void setKm(String km) {
        this.km = km;
    }

    public String getAnneeImmatriculation() {
        return anneeImmatriculation;
    }

    public void setAnneeImmatriculation(String anneeImmatriculation) {
        this.anneeImmatriculation = anneeImmatriculation;
    }
}
