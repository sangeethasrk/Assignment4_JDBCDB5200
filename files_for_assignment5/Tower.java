/* Assignment 5 */
package entity;
import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@NamedQuery(name="Tower.findAll", query="SELECT t FROM Tower t")
public class Tower implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private double height;
	private String name;
	private int sides;

	@OneToMany(mappedBy="tower")
	private List<Equipment> equipments;

	@ManyToOne
	@JoinColumn(name="siteId")
	@JsonIgnore
	private Site site;

	public Tower() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getHeight() {
		return this.height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSides() {
		return this.sides;
	}

	public void setSides(int sides) {
		this.sides = sides;
	}

	public List<Equipment> getEquipments() {
		return this.equipments;
	}

	public void setEquipments(List<Equipment> equipments) {
		this.equipments = equipments;
	}

	public Equipment addEquipment(Equipment equipment) {
		getEquipments().add(equipment);
		equipment.setTower(this);

		return equipment;
	}

	public Equipment removeEquipment(Equipment equipment) {
		getEquipments().remove(equipment);
		equipment.setTower(null);

		return equipment;
	}

	public Site getSite() {
		return this.site;
	}

	public void setSite(Site site) {
		this.site = site;
	}
}