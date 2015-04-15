/* Assignment 5 */
package entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NamedQuery(name="findAllSites", query="SELECT s FROM Site s")
public class Site implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private double latitude;
	private double longitude;
	private String name;

	@OneToMany(mappedBy="site")
	private List<Tower> towers;

	public Site() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Tower> getTowers() {
		return this.towers;
	}

	public void setTowers(List<Tower> towers) {
		this.towers = towers;
	}

	public Tower addTower(Tower tower) {
		getTowers().add(tower);
		tower.setSite(this);
		return tower;
	}

	public Tower removeTower(Tower tower) {
		getTowers().remove(tower);
		tower.setSite(null);
		return tower;
	}

	@Override
	public String toString() {
		return "Site [id=" + id + ", latitude=" + latitude + ", longitude="
				+ longitude + ", name=" + name + ", towers=" + towers + "]";
	}
}