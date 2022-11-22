package app.bank.model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Date;
import java.util.Hashtable;

import javax.imageio.stream.ImageOutputStream;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import lombok.Getter;
import lombok.Setter;


public class Fatura {
	
	@Getter  @Setter
	private static double valorFatura;
	
	@Getter  @Setter
	private static Date dataVencimento;
	
	@Getter 	@Setter
	private static String descricaoCompra;
	
	@Getter @Setter
	private static int nParcela;
	
	@Getter @Setter
	private static int senhaFatura;
	
	
	 @Getter 
	private static int[] nCartao;
	 
	 public static boolean setNCartao(int[] nCartao) {
		return true;
	}
	 
	 public static Fatura getFatura() {
		 Fatura fatura = new Fatura();
		 return fatura;
	 }

	public Fatura getNCartao(int[] nCartao2) {
		Fatura nCartao = ConverteFatura.faturaConverte(nCartao2);
		return nCartao;
	}

	public Fatura getValorFatura(double valorFatura) {
		Fatura valorDaFatura = ConverteFatura.faturaConverte(valorFatura);
		return valorDaFatura;
	}
	
	public Fatura getDataVencimento(Date dataVencimento) {
		Fatura dataDeVencimento = ConverteFatura.faturaConverte(dataVencimento);
		return dataDeVencimento;
	}

	public Fatura getDescricaoCompra(String descricao) {
		Fatura desc = ConverteFatura.faturaConverte(descricao);
		return desc;
	}
	
	public Fatura getNParcela(int nParcela) {
		Fatura nmParcela = ConverteFatura.faturaConverte(nParcela);
		return nmParcela;
	}
	
	
	public Fatura getSenhaFatura(int senha) {
		Fatura senhaFatura = ConverteFatura.faturaConverte(senha);
		return senhaFatura;
	}
	
	public static Fatura gerarFatura(int[]nCartao,double valorFatura, Date dataVencimento, String desc, int nParcela) {
			Fatura fatura = getFatura();
			fatura.getNCartao(nCartao).getValorFatura(valorFatura).getDescricaoCompra(desc)
				.getNParcela(nParcela);
			return fatura;
	}
	
	public static Fatura consultaFatura(int [] nCartao,  int senha) {
		Fatura fatura = getFatura();
		fatura.getNCartao(nCartao).getSenhaFatura(senha);
		return fatura;
	}
	
	public void pagamentoFatura(int[] nCartao,double valorFatura, int senha) {
		Fatura fatura = getFatura();
		fatura.getNCartao(nCartao).getValorFatura(valorFatura)
			.getSenhaFatura(senha);
	}

	public static Fatura gerarFatura(boolean setNCartao, Object setValorFatura, Object setDataVencimento,
			Object setDescricaoCompra, Object setNParcela, String desc) {
		Fatura fatura = getFatura();
		fatura.getNCartao(nCartao).getValorFatura(valorFatura).getDescricaoCompra(desc)
			.getNParcela(nParcela);
		return fatura;
	}

	public static Fatura gerarFaturaF(boolean setNCartao, Object setValorFatura, Object setDataVencimento,
			Object setDescricaoCompra, Object setNParcela) {
		Fatura fatura = getFatura();
		fatura.getNCartao(nCartao).getValorFatura(valorFatura).getDescricaoCompra(setDescricaoCompra.toString())
			.getNParcela(nParcela);
		
		//gerarQRCode(ImageOutputStream valorS, String qrCodeText, int size, String fileType);
		return fatura;
	}

	public static Fatura consultaFatura(boolean setNCartao, Object setSenhaFatura) {
		Fatura fatura = getFatura();
		fatura.getNCartao(setNCartao).
				getSenhaFatura(Integer.parseInt(setSenhaFatura.toString()));
		return fatura;
	}

	private Fatura getNCartao(boolean setNCartao) {
		return null;
	}

	public Fatura pagamentoFatura(boolean setNCartao, Object setValorFatura, Object setSenhaFatura) {
		Fatura fatura = getFatura();
		fatura.getNCartao(nCartao).getValorFatura(valorFatura)
			.getSenhaFatura(Integer.parseInt(setSenhaFatura.toString()));
		return fatura;
	}
	
	
	public void gerarQRCode(ImageOutputStream valorS, String qrCodeText, int size, String fileType) throws WriterException, IOException {
		Hashtable<EncodeHintType, ErrorCorrectionLevel> map = new Hashtable<>();
		map.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
		QRCodeWriter codeWriter = new QRCodeWriter();
		BitMatrix byteMatrix = codeWriter.
					encode(qrCodeText, BarcodeFormat.QR_CODE, size, size,map);
			int matrixWidth = byteMatrix.getWidth();
			BufferedImage bufferedImage = new BufferedImage(matrixWidth, matrixWidth, BufferedImage.TYPE_INT_RGB);
			bufferedImage.createGraphics();
				Graphics2D graphics2d = (Graphics2D) bufferedImage.getGraphics();
				graphics2d.setColor(Color.white);
				graphics2d.fillRect(0, 0, matrixWidth, matrixWidth);
				graphics2d.setColor(Color.black);
					for(int i=0;i<matrixWidth; i++) {
						for(int j=0; j<matrixWidth; j++) {
							if(byteMatrix.get(i, j)) {
								graphics2d.fillRect(i, j, 1, 1);
							}
						}
					}
					
					double valorFatura = getValorFatura();
					 setValorFatura(valorFatura);
					}

}
	


	



class ConverteFatura{
	
	public static Fatura faturaConverte(Object fatura) {
		if(fatura != null) {
			return (Fatura) fatura;
		}
		return null;
	}
	
}
