package api.data.AdInsertData;

public class AdInsertImmoData extends AdInsertBase {
    private String
        adNbrPieces,
        adAdresse,
        adSuperficie;

    public AdInsertImmoData(AdInsertBase adInsertBase, String adNbrPieces, String adAdresse, String adSuperficie) {
        super(adInsertBase.subject, adInsertBase.body, adInsertBase.price, adInsertBase.cityWording, adInsertBase.secteur, adInsertBase.name, adInsertBase.email, adInsertBase.emailNu, adInsertBase.phone, adInsertBase.password);
        this.adNbrPieces = adNbrPieces;
        this.adAdresse = adAdresse;
        this.adSuperficie = adSuperficie;
    }

    public String getAdNbrPieces() {
        return adNbrPieces;
    }

    public void setAdNbrPieces(String adNbrPieces) {
        this.adNbrPieces = adNbrPieces;
    }

    public String getAdAdresse() {
        return adAdresse;
    }

    public void setAdAdresse(String adAdresse) {
        this.adAdresse = adAdresse;
    }

    public String getAdSuperficie() {
        return adSuperficie;
    }

    public void setAdSuperficie(String adSuperficie) {
        this.adSuperficie = adSuperficie;
    }

}
