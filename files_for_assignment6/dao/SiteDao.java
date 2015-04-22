/* Assignment 6 */
package dao;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.*;
import javax.xml.bind.*;
import javax.persistence.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import entity.Site;
import entity.SiteList;	

public class SiteDao 
{	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("xslt_jpa");
	EntityManager em = null;
	
	public Site findSite(int siteId)
	{
		Site site = null;

		em = factory.createEntityManager();
		em.getTransaction().begin();

		site = em.find(Site.class, siteId);

		em.getTransaction().commit();
		em.close();

		return site;
	}
	
	public List<Site> findAllSites()
	{
		List<Site> sites = new ArrayList<Site>();

		em = factory.createEntityManager();
		em.getTransaction().begin();

		Query query = em.createNamedQuery("findAllSites");
		sites = query.getResultList();

		em.getTransaction().commit();
		em.close();

		return sites;
	}
	
	public void exportSiteDatabaseToXmlFile(SiteList siteList, String xmlFileName)
	{
		File file = new File(xmlFileName);
		try 
		{
			JAXBContext context = JAXBContext.newInstance(SiteList.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(siteList, file);
		} 
		catch (JAXBException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void convertXmlFileToOutputFile(String inputXmlFileName, String outputXmlFileName, String xsltFileName)
	{
		File inputXmlFile = new File(inputXmlFileName);
		File outputXmlFile = new File(outputXmlFileName);
		File xsltFile = new File(xsltFileName);

		StreamSource source = new StreamSource(inputXmlFile);
		StreamSource xslt   = new StreamSource(xsltFile);
		StreamResult output = new StreamResult(outputXmlFile);

		TransformerFactory factory = TransformerFactory.newInstance();
		try 
		{
			Transformer transformer = factory.newTransformer(xslt);
			transformer.transform(source, output);
		} 
		catch (TransformerConfigurationException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (TransformerException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{
		SiteDao siteDao = new SiteDao();
		List<Site> findAllSites = siteDao.findAllSites(); 
		SiteList siteList = new SiteList();
		siteList.setSites(findAllSites);
		siteDao.exportSiteDatabaseToXmlFile(siteList, "xml/sites.xml");
		
		siteDao.convertXmlFileToOutputFile("xml/sites.xml", "xml/sites.html", "xml/sites2html.xslt");
		siteDao.convertXmlFileToOutputFile("xml/sites.xml", "xml/equipments.html", "xml/sites2equipment.xslt");		
	}	
}