package Model;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class ApiResponse implements Serializable {
    @SerializedName("code")
    int code;
    @SerializedName("type")
    String type;
    @SerializedName("message")
    String message;
}
