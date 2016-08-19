package project.model;

import net.sf.oval.constraint.*;
import project.util.VinCheck;

import java.sql.Date;


/**
 * Created on 15.08.2016.
 */
public class Car {
    private Integer id;

    @NotNull(message = "Field is empty")
    @NotEmpty (message = "Field is empty")
    private String model;

    @NotNull (message = "Field is empty")
    @NotEmpty (message = "Field is empty")
    private Date productionDate;

    @NotNull(message = "Field is empty")
    @NotEmpty(message = "Field is empty")
    private String manufacturer;

    @NotNull(message = "Field is empty")
    @NotEmpty(message = "Field is empty")
    @Email (message = "E-mail is not real")
    private String manufacturerEmail;

    @NotNull(message = "Field is empty")
    @NotEmpty(message = "Field is empty")
    @Min(value = 0, message = "Negative value")
    private Integer motorShowId;

    @NotNull(message = "Field is empty")
    @NotEmpty(message = "Field is empty")
    @Min(value = 0, message = "Negative value")
    private Double price;

    @NotNull(message = "Field is empty")
    @NotEmpty(message = "Field is empty")
    @Min(value = 0, message = "Negative value")
    private Double engineVolume;

    @NotNull(message = "Field is empty")
    @NotEmpty(message = "Field is empty")
    @CheckWith(value = VinCheck.class, message = "Car already exists")
    private String vinCode;


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public String getManufacturerEmail() {
        return manufacturerEmail;
    }

    public void setManufacturerEmail(String manufacturerEmail) {
        this.manufacturerEmail = manufacturerEmail;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMotorShowId() {
        return motorShowId;
    }

    public void setMotorShowId(Integer motorShowId) {
        this.motorShowId = motorShowId;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(Double engineVolume) {
        this.engineVolume = engineVolume;
    }

    public String getVinCode() {
        return vinCode;
    }

    public void setVinCode(String vinCode) {
        this.vinCode = vinCode;
    }
}
