package ead.mobile.scan_me.Class;

/**
 * Created by GL552VW on 24/04/2019.
 */

public class StuffData {
    String id,name,type,merk,status,date,specs;

    public StuffData(String id, String name, String type, String merk, String status, String date, String specs) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.merk = merk;
        this.status = status;
        this.date = date;
        this.specs = specs;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getMerk() {
        return merk;
    }

    public String getStatus() {
        return status;
    }

    public String getDate() {
        return date;
    }

    public String getSpecs() {
        return specs;
    }
}
