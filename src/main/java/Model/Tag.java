package Model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tag implements Serializable {
    @SerializedName("id")
    private Long id;
    @SerializedName("name")
    private String name;
}
