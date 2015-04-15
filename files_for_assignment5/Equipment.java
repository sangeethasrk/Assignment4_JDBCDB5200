/* Assignment 5 */
package entity;
import javax.persistence.*;
import java.io.Serializable;
import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@NamedQuery(name="Equipment.findAll", query="SELECT eq FROM Equipment eq")
public class Equipment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String brand;
	private String description;
	private String name;
	private double price;

	@ManyToOne
	@JoinColumn(name="towerId")
	@JsonIgnore
	private Tower towerobj;

	public Equipment() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Tower getTower() {
		return this.towerobj;
	}

	public void setTower(Tower towerobj) {
		this.towerobj = towerobj;
	}
}