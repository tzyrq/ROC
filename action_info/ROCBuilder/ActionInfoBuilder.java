package ROCBuilder;

import ROC.*;
import com.google.flatbuffers.FlatBufferBuilder;

class ActionInfoBuilder {
    private String uavId;
    private String lat;
    private String lng;

    public ActionInfoBuilder() {
        uavId = "";
        lat = "";
        lng = ""; 
    }

    public void setUavId(String uavId) {
        this.uavId = uavId; 
    }

    public String getUavId() {
        return this.uavId;
    }

    public void setLat(String lat) {
        this.lat = lat;  
    } 

    public String getLat() {
        return this.lat; 
    }

    public void setLng(String lng) {
        this.lng = lng; 
    }

    public String getLng() {
        return this.lng; 
    }

    public byte[] buildFB() {
        FlatBufferBuilder builder = new FlatBufferBuilder(0);
        int uav_id = builder.createString(uavId);
        int latitude = builder.createString(lat);
        int longitude = builder.createString(lng);

        ActionInfo.startActionInfo(builder);
        ActionInfo.addUavId(builder, uav_id);
        ActionInfo.addLatitude(builder, latitude);
        ActionInfo.addLongitude(builder, longitude);
        int orc = ActionInfo.endActionInfo(builder);
        builder.finish(orc);
        byte[] buf = builder.sizedByteArray();

        return buf;
    }
}
