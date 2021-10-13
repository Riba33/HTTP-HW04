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
public class Order implements Serializable {
    @SerializedName("id")
    private Long id;
    @SerializedName("petId")
    private Long petId;
    @SerializedName("quantity")
    private int quantity;
    @SerializedName("shipDate")
    private String shipDate;
    @SerializedName("status")
    private OrderStatus status;
    @SerializedName("complete")
    private boolean complete;

}
