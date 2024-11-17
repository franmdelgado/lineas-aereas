package model;

import java.util.ArrayList;
import java.util.List;

public class ShortestPathResponse {
    private List<String> path;
    private float totalCost;

    public ShortestPathResponse() {
        this.path = new ArrayList<>();
    }

    public List<String> getPath() {
        return path;
    }

    public void setPath(List<String> path) {
        this.path = path;
    }

    public float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }
}
