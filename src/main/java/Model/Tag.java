package Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Tag implements Serializable {
    @SerializedName("id")
    private Long id;
    @SerializedName("name")
    private String name;
}
