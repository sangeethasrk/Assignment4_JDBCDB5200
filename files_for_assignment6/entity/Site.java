/* Assignment 6 */
package entity;
import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.List;

@Entity
@XmlRootElement
@XmlAccessorType(value = XmlAccessType.FIELD)
@NamedQuery(name="findAllSites", query="SELECT s FROM Site s")
public class Site implements Serializable 
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@XmlAttribute
	private int id;

	@XmlAttribute
	private double latitude;

	@XmlAttribute
	private double longitude;

	@XmlAttribute
	private String name;

	@OneToMany(mappedBy="site")
	@XmlElement(name="tower")
	private List<Tower> towers;

	public Site() 
	{
	}

	public int getId() 
	{
		return this.id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public double getLatitude() 
	{
		return this.latitude;
	}

	public void setLatitude(double latitude) 
	{
		this.latitude = latitude;
	}

	public double getLongitude() 
	{
		return this.longitude;
	}

	public void setLongitude(double longitude) 
	{
		this.longitude = longitude;
	}

	public String getName() 
	{
		return this.name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public List<Tower> getTowers() 
	{
		return this.towers;
	}

	public void setTowers(List<Tower> towers) 
	{
		this.towers = towers;
	}

	public Tower addTower(Tower tower) 
	{
		getTowers().add(tower);
		tower.setSite(this);
		return tower;
	}

	public Tower removeTower(Tower tower) 
	{
		getTowers().remove(tower);
		tower.setSite(null);
		return tower;
	}
}