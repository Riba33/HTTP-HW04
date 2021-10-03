package Model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pet implements Serializable {
    @SerializedName("id")
    private Long id;
    @SerializedName("category")
    private Category category;
    @SerializedName("name")
    private String name;
    @SerializedName("photoUrls")
    private String[] photoUrls;
    @SerializedName("tags")
    private Tag[] tags;
    @SerializedName("status")
    private PetStatus status;

}
