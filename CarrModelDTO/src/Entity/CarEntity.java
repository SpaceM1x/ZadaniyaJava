package Entity;

public class CarEntity {
    private int id;
    private int modelId;
    private int dealerId;

    public CarEntity() {}

    public CarEntity(int id, int modelId, int dealerId) {
        this.id = id;
        this.modelId = modelId;
        this.dealerId = dealerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public int getDealerId() {
        return dealerId;
    }

    public void setDealerId(int dealerId) {
        this.dealerId = dealerId;
    }
}
