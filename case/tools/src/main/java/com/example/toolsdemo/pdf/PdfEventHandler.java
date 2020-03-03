
package com.example.toolsdemo.pdf;

import java.awt.FontMetrics;
import javax.swing.JLabel;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.ColumnText;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfGState;
import com.lowagie.text.pdf.PdfPageEventHelper;
import com.lowagie.text.pdf.PdfTemplate;
import com.lowagie.text.pdf.PdfWriter;

public class PdfEventHandler extends PdfPageEventHelper {


	private static PdfEventHandler pdfFooter=null;
	private float presentFontSize = 0f;
	private PdfTemplate total=null;;
	private BaseFont bf=null;
	private Font fontDetail = null;

	private BaseFont base=null;

	public static PdfEventHandler getInstance(Font footerFont,BaseFont waterBase) {
		if (pdfFooter == null) {
			pdfFooter = new PdfEventHandler(footerFont,waterBase);
		}
		return pdfFooter;
	}

	private PdfEventHandler() {
	}

	private PdfEventHandler(Font font,BaseFont base) {
		this.bf = font.getBaseFont();
		this.presentFontSize = font.getCalculatedSize();
		this.fontDetail = font;
		this.base=base;
	}

	public void setPresentFontSize(int presentFontSize) {
		this.presentFontSize = presentFontSize;
	}

	@Override
	public void onOpenDocument(PdfWriter writer, Document document) {
		total = writer.getDirectContent().createTemplate(50, 50);
	}

	@Override
	public void onEndPage(PdfWriter writer, Document document) {

		addFooter(writer,document);
		addWater(writer,document);

		super.onEndPage(writer, document);
	}
	/**
	 * 添加水印
	 * @param writer
	 * @param document
	 */
	private void addWater(PdfWriter writer, Document document) {

		int interval=-5;
		Rectangle pageRect=document.getPageSize();
		PdfGState gs = new PdfGState();
		//设置水印透明度
		gs.setFillOpacity(0.1f);
		gs.setStrokeOpacity(0.2f);
		JLabel label = new JLabel();
		FontMetrics metrics;
		int textH = 0;
		int textW = 0;
		label.setText("水印");
		metrics = label.getFontMetrics(label.getFont());
		textH = metrics.getHeight()+3;
		textW = metrics.stringWidth(label.getText())+32;
		PdfContentByte over = writer.getDirectContentUnder();
		over.saveState();
		over.setGState(gs);
		over.beginText();
		over.setFontAndSize(base, 15);
		//水印倾斜45度，平铺展示
		for(int height=interval+textH;height<pageRect.height();height=height+textH*8){
			for(int width=interval+textW;width<pageRect.width()+textW;width=width+textW){
				over.showTextAligned(Element.ALIGN_LEFT, "水印", width-textW,height-textH,45);
			}
		}
	}
	/**
	 * 添加页脚
	 * @param writer
	 * @param document
	 */
	private void addFooter(PdfWriter writer, Document document) {
		int pageS = writer.getPageNumber();
		String foot = "第" + pageS + "页/共";
		Phrase footer = new Phrase(foot, fontDetail);

		float len = bf.getWidthPoint(foot, presentFontSize);

		PdfContentByte cb = writer.getDirectContent();

		ColumnText.showTextAligned(cb,
				Element.ALIGN_CENTER,
				footer,(document.rightMargin() + document.right()
						+ document.leftMargin() - document.left() - len) / 2.0f + 20f,
				document.bottom() - 20, 0);
		cb.addTemplate(total, (document.rightMargin() + document.right()
						+ document.leftMargin() - document.left()) / 2.0f + 20f,
				document.bottom() - 20);
	}

	@Override
	public void onCloseDocument(PdfWriter writer, Document document) {
		total.beginText();
		total.setFontAndSize(bf, presentFontSize);
		String foot = "" + (writer.getPageNumber() - 1) + "页";
		total.showText(foot);
		total.endText();
		total.closePath();
		super.onCloseDocument(writer, document);
	}
}
