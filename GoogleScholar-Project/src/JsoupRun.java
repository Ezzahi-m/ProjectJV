import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupRun {

	public static void main(String[] args) throws IOException
	{
		Document doc = Jsoup.connect("https://scholar.google.com/citations?view_op=top_venues&hl=fr")
				.timeout(6000).get();
		Elements body = doc.select("tbody");
		// pour compter les publications
		//System.out.println(body.select("tr").size());
		for(Element e : body.select("tr"))
		{
			// les publications
		    String title = e.select("th.gsc_mvt_t ").text();
			System.out.println(title);
			// Ordre des publications 
			String ordre = e.select("td.gsc_mvt_p").text().trim();
			System.out.println(ordre);
			// le nom de chaque publication
			String pub = e.select("td.gsc_mvt_t").text().trim();
			System.out.println(pub);
			// l'indice et le médiane de chaque Publication
			String indice = e.select("td.gsc_mvt_n").text().trim();
			System.out.println(indice);
		}
	}

}
