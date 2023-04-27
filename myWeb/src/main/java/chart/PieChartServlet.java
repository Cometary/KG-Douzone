package chart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 * Servlet implementation class PieChartServlet
 */
@WebServlet("/PieChartServlet")
public class PieChartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PieChartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 데이터를 생성한다.
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("Son-OGong", 63.2);
		dataset.setValue("Jer-PalGae", 37.9);
		dataset.setValue("Sa-OJung", 29.5);
		// 2. 차트를 만든다. 
		JFreeChart chart = ChartFactory.createPieChart("Energy Power", dataset, true, true, false );
		// 4. 차트를 보여준다.
		ServletOutputStream out = response.getOutputStream();
		ChartUtils.writeChartAsPNG(out, chart, 400, 400);
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
