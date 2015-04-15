/* Assignment 5 */
package dao;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import entity.Site;

@Path("/site")
public class SiteDao {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("xslt_jpa");
	EntityManager emanager = null;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{ID}")
	public Site findSite(@PathParam(value = "ID")int siteId){
		Site site = null;
		EntityManager emanager = factory.createEntityManager();
		emanager.getTransaction().begin();
		site = emanager.find(Site.class, siteId);
		emanager.getTransaction().commit();
		emanager.close();
		return site;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public List<Site> findAllSites(){
		List<Site> sites = new ArrayList<Site>();
		EntityManager emanager = factory.createEntityManager();
		emanager.getTransaction().begin();
		sites = emanager.createNamedQuery("findAllSites").getResultList();
		emanager.getTransaction().commit();
		emanager.close();
		return sites;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public List<Site> createSite(Site site) {
		List<Site> sites = new ArrayList<Site>();

		emanager = factory.createEntityManager();
		emanager.getTransaction().begin();

		emanager.persist(site);
		Query query = emanager.createNamedQuery("findAllSites");
		sites = query.getResultList();

		emanager.getTransaction().commit();
		emanager.close();
		return sites;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{ID}")
	public List<Site> updateSite(@PathParam(value = "ID")int siteId, Site site){
		List<Site> sites = new ArrayList<Site>();

		emanager = factory.createEntityManager();
		emanager.getTransaction().begin();

		site.setId(siteId);
		emanager.merge(site);

		Query query = emanager.createNamedQuery("findAllSites");
		sites = query.getResultList();

		emanager.getTransaction().commit();
		emanager.close();
		return sites;
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{ID}")
	public List<Site> removeSite(@PathParam(value = "ID")int siteId){
		List<Site> sites = new ArrayList<Site>();

		Site site = null;

		emanager = factory.createEntityManager();
		emanager.getTransaction().begin();

		site = emanager.find(Site.class, siteId);
		emanager.remove(site);

		Query query = emanager.createNamedQuery("findAllSites");
		sites = query.getResultList();

		emanager.getTransaction().commit();
		emanager.close();

		return sites;
	}
	
	public static void main(String[] args) {
		SiteDao siteDao = new SiteDao();
		Site findSite = siteDao.findSite(1);
		System.out.println(findSite);
		
		List<Site> findAllSites = siteDao.findAllSites();
		System.out.println(findAllSites);
	}
}