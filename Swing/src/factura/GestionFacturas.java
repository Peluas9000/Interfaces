package factura;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;

import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class GestionFacturas {

    // --- MAIN: lanza la ventana principal ---
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            try {
                Factura frame = new Factura();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    // --- MÉTODO PARA EXPORTAR EL ARRAYLIST A PDF ---
    public static void exportarFacturasAPDF(ArrayList<FacturaObjeto> facturas) {
        if (facturas == null || facturas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay facturas para exportar.", 
                    "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Pedir ubicación para guardar el archivo
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Guardar listado de facturas");
        chooser.setFileFilter(new FileNameExtensionFilter("Archivos PDF", "pdf"));
        int seleccion = chooser.showSaveDialog(null);
        if (seleccion != JFileChooser.APPROVE_OPTION) return;

        File file = chooser.getSelectedFile();
        if (!file.getName().toLowerCase().endsWith(".pdf")) {
            file = new File(file.getParentFile(), file.getName() + ".pdf");
        }

        try {
            crearPDF(facturas, file);
            JOptionPane.showMessageDialog(null, 
                    "PDF exportado correctamente:\n" + file.getAbsolutePath(),
                    "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, 
                    "Error al generar PDF: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // --- CREA EL DOCUMENTO PDF ---
    private static void crearPDF(ArrayList<FacturaObjeto> facturas, File file) throws IOException {
        final float MARGIN = 50;
        final float Y_START = PDRectangle.A4.getHeight() - MARGIN;
        final float LEADING = 18f;
        final DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try (PDDocument doc = new PDDocument()) {
            PDPage page = new PDPage(PDRectangle.A4);
            doc.addPage(page);
            PDPageContentStream cs = new PDPageContentStream(doc, page);

            PDFont fontTitulo = new Standard14Fonts.Font(Standard14Fonts.FontName.HELVETICA_BOLD);
            PDFont fontTexto  = new Standard14Fonts.Font(Standard14Fonts.FontName.HELVETICA);

            // Título
            cs.beginText();
            cs.setFont(fontTitulo, 18);
            cs.newLineAtOffset(MARGIN, Y_START);
            cs.showText("LISTADO DE FACTURAS");
            cs.endText();

            float y = Y_START - 40;

            // Cabecera
            cs.beginText();
            cs.setFont(fontTexto, 12);
            cs.newLineAtOffset(MARGIN, y);
            cs.showText(String.format("%-15s %-15s %-15s %-15s", 
                    "ASUNTO", "FECHA", "CANTIDAD", "TIPO"));
            cs.endText();

            y -= LEADING;

            // Contenido
            cs.setFont(PDType1Font.HELVETICA, 11);
            for (FacturaObjeto f : facturas) {
                if (y < 70) { // salto de página
                    cs.close();
                    page = new PDPage(PDRectangle.A4);
                    doc.addPage(page);
                    cs = new PDPageContentStream(doc, page);
                    y = Y_START - 40;
                    cs.setFont(PDType1Font.HELVETICA, 11);
                }

                String linea = String.format("%-15.15s %-15s %-15s %-15.15s",
                        f.getAsunto(),
                        f.getFecha().format(df),
                        f.getCantidad() + "€",
                        f.getTipo());

                cs.beginText();
                cs.newLineAtOffset(MARGIN, y);
                cs.showText(linea);
                cs.endText();
                y -= LEADING;
            }

            cs.close();
            doc.save(file);
        }
    }
}
