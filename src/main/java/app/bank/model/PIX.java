package app.bank.model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import app.bank.enumeratiom.TipoChave;
import lombok.Data;

@Data
public class PIX {

	private ClientePF chavePIXpf;
	private ClientePJ chavePIXpj;
	private String chavePIX;
	private double valorTransacao;
	
	public void cadastroChavePixRG(String rg) {
		chavePIX = chavePIXpf.setRG(rg);
	}

	public void cadastroChavePIXcpf(String cpf) {
		chavePIX = 	chavePIXpf.setCPF(cpf);
	}
	
	public void cadastroChavePIXtelefone(String telefone) {
		chavePIX = 	chavePIXpf.setTelefone(telefone);
	}
	
	public void cadastroChavePIXcnpj(String cnpj) {
		chavePIX =  chavePIXpj.setCNPJj(cnpj);
	}
	
	
	
	private List<Transacoes> dataTransferencia(Date dataTransferencia) {
		return this.dataTransferencia(dataTransferencia);
	}
	
	public List<Transacoes> valorTransacao(double valorTransacao) {
		List<Transacoes> valorTransacoes = new ArrayList<>();//
			return valorTransacoes;
	}
	
	
	
	public List<Transacoes> pixProgramado(TipoChave[] tipoChave,String valorChave, double valor, Date dataDeTransferencia) {
		List<Transacoes> pixProgramado = new ArrayList<>();
		
		pixProgramado = 	this.valorTransacao(valor);
		pixProgramado =	this.tipoChave(tipoChave);
		
		pixProgramado =	this.dataTransferencia(dataDeTransferencia);
		return pixProgramado;
	}
	
	@SuppressWarnings("unlikely-arg-type")
	private List<Transacoes> tipoChave(TipoChave[] tipoChave) {
			List<Transacoes> chave  = new ArrayList<>();
			
			TipoChave.CNPJ.compareTo(TipoChave.CNPJ);
			TipoChave.CPF.compareTo(TipoChave.CPF);
			TipoChave.telefone.compareTo(TipoChave.telefone);
			TipoChave.RG.compareTo(TipoChave.RG);
			chave.contains(tipoChave);
			return chave;
	}

	public List<Transacoes> realizarTransacao(TipoChave[] tipoChave,String chave, double valor) {
		List<Transacoes> pix = new ArrayList<>();
		pix =	this.setChavePIX(chave);
		pix =	this.valorTransacao(valor);
		pix =	this.tipoChave(tipoChave);
		return pix;
	}
	
	public List<Transacoes> setChavePIX(String chavePix){
		List<Transacoes> chave =new  ArrayList<>();
		return chave;
	}
	
	
	public void valorChave(String valorChave) {
		this.valorChave(valorChave);
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
						
						double valor = valor();
						String chaveString = chave();
						cobrancaPIX(valor, chaveString);
						ImageIO.write(bufferedImage, fileType, valorS);
						
				}
	
			private double valor() {
				return this.valor();
			}
			
			private String chave() {
				return this.chave();
			}
	
			private void cobrancaPIX(double valor , String chave) {
				this.valorTransacao =valor;
				this.chavePIX = chave;
			}
	
}

