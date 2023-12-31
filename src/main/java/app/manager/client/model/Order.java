package app.manager.client.model;

import app.manager.client.dto.ProductDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order")
public class Order{
    @Id
    private String id;

    private String customerName;
    private double totalPrice;
    private List<ProductDTO> productDTOList;
}
