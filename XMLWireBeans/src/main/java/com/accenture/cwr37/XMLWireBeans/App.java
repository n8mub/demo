package com.accenture.cwr37.XMLWireBeans;

import java.io.FileInputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.transform.stream.StreamResult;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.dom4j.DocumentHelper;
import org.springframework.oxm.xstream.XStreamMarshaller;

import com.comerica.tfr.data.beans.BankAcctTrnRec;
import com.comerica.tfr.data.beans.BankInfo;
import com.comerica.tfr.data.beans.BankSvcRs;
import com.comerica.tfr.data.beans.CMA;
import com.comerica.tfr.data.beans.CurAmt;
import com.comerica.tfr.data.beans.CustId;
import com.comerica.tfr.data.beans.DepAcctId;
import com.comerica.tfr.data.beans.DepAcctTrnInqRs;
import com.comerica.tfr.data.beans.DepAcctTrnRec;
import com.comerica.tfr.data.beans.Status;
import com.comerica.tfr.data.beans.TransactionFlat;

/**
 * Hello world!
 *
 */
public class App {
	private static String SENDING_BANK = "Sending Bank";
	private static String SENDING_BANK_REFERENCE = "Sending Bank Reference";
	private static String RECEIVING_BANK = "Receiving Bank";
	private static String BENEFICIARY_BANK = "Beneficiary Bank";
	private static String BENEFICIARY = "Beneficiary";
	private static String REFERENCE_FOR_BENEFICIARY = "Reference for Beneficiary";
	private static String ORIGINATOR = "Originator";
	private static String ORIGINATORS_BANK = "Originator's Bank";
	private static String INSTRUCTING_BANK = "Instructing Bank";
	private static String ORIGINATOR_TO_BENEFICIARY_INFO = "Originator to Beneficiary Info";
	private static String AMOUNT = "Amount";
	private static String ACCEPTANCE_TIMESTAMP = "Acceptance Timestamp";
	private static String OMAD_FIELDS = "OMAD Fields";
	private static String IMAD = "IMAD";
	private static String CHARGES = "Charges";
	private static String INSTRUCTED_AMOUNT = "Instructed Amount";
	private static String BUSINESS_FUNCTION_CODE = "Business Function Code";
	private static String RQUID_PREFIX = "00000000-0000-0000-0000-";
	
	public static void main(String[] args) {
		List<TransactionFlat> transactionFlats = readexcel();
		generatexml(transactionFlats);
	}
	
	private static List<TransactionFlat> readexcel() {
		List<TransactionFlat> transactionFlats = new ArrayList<TransactionFlat>();
		try {
			FileInputStream fileInputStream = new FileInputStream("src/main/resources/text_desc.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
			XSSFSheet sheet = workbook.getSheetAt(0);
			for(int i = 1;i < sheet.getLastRowNum();i++) {
				XSSFRow row = sheet.getRow(i);
				TransactionFlat transactionFlat = new TransactionFlat();
				transactionFlat.setTransactionId(Integer.toString(new Double(row.getCell(0).getNumericCellValue()).intValue()));
				transactionFlat.setAccountFlatId(Integer.toString(new Double(row.getCell(1).getNumericCellValue()).intValue()));
				transactionFlat.setAbaRoutingNumber(Integer.toString(new Double(row.getCell(2).getNumericCellValue()).intValue()));
				transactionFlat.setTypeCode(Integer.toString(new Double(row.getCell(3).getNumericCellValue()).intValue()));
				transactionFlat.setCurrencyId(Integer.toString(new Double(row.getCell(4).getNumericCellValue()).intValue()));
				transactionFlat.setTransactionAmount(Double.toString(row.getCell(5).getNumericCellValue()));
				transactionFlat.setFundsType(row.getCell(6).getStringCellValue());
				if(row.getCell(7) != null) {
					transactionFlat.setBankReferenceNumber(row.getCell(7).getStringCellValue());
				}
				transactionFlat.setCustomerReferenceNumber(Integer.toString(new Double(row.getCell(8).getNumericCellValue()).intValue()));
				transactionFlat.setTextDesc(row.getCell(11).getStringCellValue());
				transactionFlat.setImmediateAvailabilityAmount(Double.toString(row.getCell(12).getNumericCellValue()));
				transactionFlat.setOneDayAvailabilityAmount(Integer.toString(new Double(row.getCell(13).getNumericCellValue()).intValue()));
				transactionFlat.setMoreThanOneDayAvailabilityAmount(Integer.toString(new Double(row.getCell(14).getNumericCellValue()).intValue()));
				transactionFlat.setCustomerAccountNumber(Integer.toString(new Double(row.getCell(16).getNumericCellValue()).intValue()));
				transactionFlat.setDebitAmount(row.getCell(18).getRawValue());
				transactionFlat.setCreditAmount(row.getCell(19).getRawValue());
				transactionFlat.setFileDate(row.getCell(20).getDateCellValue().toString());
				transactionFlat.setCreatedDate(row.getCell(21).getDateCellValue().toString());
				transactionFlat.setTransactionTypeId(Integer.toString(new Double(row.getCell(22).getNumericCellValue()).intValue()));
				transactionFlat.setTransactionTypeDesc(row.getCell(23).getStringCellValue());
				transactionFlat.setTypeDesc(row.getCell(24).getStringCellValue());
				transactionFlat.setCreditInd(Integer.toString(new Double(row.getCell(25).getNumericCellValue()).intValue()));
				transactionFlat.setDebitInd(Integer.toString(new Double(row.getCell(26).getNumericCellValue()).intValue()));
				transactionFlat.setInserted(row.getCell(27).getDateCellValue().toString());
				transactionFlat.setBalanceAmount(row.getCell(28).getRawValue());
				transactionFlat.setAsOfDate(row.getCell(29).getDateCellValue().toString());
				transactionFlat.setPriorDayInd(Integer.toString(new Double(row.getCell(30).getNumericCellValue()).intValue()));
				transactionFlat.setCurrentDayInd(Integer.toString(new Double(row.getCell(31).getNumericCellValue()).intValue()));
				transactionFlat.setUnitOfWorkId(Integer.toString(new Double(row.getCell(32).getNumericCellValue()).intValue()));
				if(Integer.toString(1).contentEquals(transactionFlat.getCurrentDayInd())) {
					transactionFlats.add(transactionFlat);
				}
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		return transactionFlats;
	}

	private static Map<String, String> parsetextdesc(String textdesc) {
		List<String> fields = new ArrayList<String>();
		fields.add(SENDING_BANK);
		fields.add(SENDING_BANK_REFERENCE);
		fields.add(RECEIVING_BANK);
		fields.add(BENEFICIARY_BANK);
		fields.add(BENEFICIARY);
		fields.add(REFERENCE_FOR_BENEFICIARY);
		fields.add(ORIGINATOR);
		fields.add(ORIGINATORS_BANK);
		fields.add(INSTRUCTING_BANK);
		fields.add(ORIGINATOR_TO_BENEFICIARY_INFO);
		fields.add(AMOUNT);
		fields.add(ACCEPTANCE_TIMESTAMP);
		fields.add(OMAD_FIELDS);
		fields.add(IMAD);
		fields.add(CHARGES);
		fields.add(INSTRUCTED_AMOUNT);
		fields.add(BUSINESS_FUNCTION_CODE);
		Map<String, List<Integer>> indexs = new HashMap<String, List<Integer>>();
		for (int i = 0; i < fields.size(); i++) {
			String field = fields.get(i) + ":";
			int first = textdesc.indexOf(field);
			int last = first + field.length();
			int end = -1;
			while(end == -1) {
				if (i < (fields.size() - 1)) {
					end = textdesc.indexOf(fields.get(i + 1) + ":");
				} else {
					end = textdesc.length();
				}
				if(end < 0) {
					i++;
				}
			}
			if (first >= 0) {
				indexs.put(field, Arrays.asList(first, last, end));
			}
		}
		Map<String, String> values = new HashMap<String, String>();
		for (String field : indexs.keySet()) {
			List<Integer> index = indexs.get(field);
			String value = textdesc.substring(index.get(1), index.get(2)).trim();
			if (value.endsWith("-")) {
				value = value.substring(0, value.length() - 1).trim();
			}
			values.put(field.substring(0, field.length() - 1), value);
		}
		return values;
	}

	private static void generatexml(List<TransactionFlat> transactionFlats) {
		List<BankSvcRs> bankSvcRs = new ArrayList<BankSvcRs>();
		for(TransactionFlat transactionFlat :transactionFlats) {
			Map<String, String> values = parsetextdesc(transactionFlat.getTextDesc());
			BankAcctTrnRec bankAcctTrnRec = new BankAcctTrnRec();
			if(Integer.toString(1).contentEquals(transactionFlat.getCreditInd())) {
				bankAcctTrnRec.setTrnType("Credit".toUpperCase());
			}else if(Integer.toString(1).contentEquals(transactionFlat.getDebitInd())) {
				bankAcctTrnRec.setTrnType("debit".toUpperCase());
			}
			bankAcctTrnRec.setPostedDt(transactionFlat.getAsOfDate());
			bankAcctTrnRec.setSendingBank(values.get(SENDING_BANK));
			bankAcctTrnRec.setSendingBankReference(values.get(SENDING_BANK_REFERENCE));
			bankAcctTrnRec.setReceivingBank(values.get(RECEIVING_BANK));
			bankAcctTrnRec.setBeneficiaryBank(values.get(BENEFICIARY_BANK));
			bankAcctTrnRec.setBeneficiary(values.get(BENEFICIARY));
			bankAcctTrnRec.setReferenceForBeneficiary(values.get(REFERENCE_FOR_BENEFICIARY));
			bankAcctTrnRec.setOriginator(values.get(ORIGINATOR));
			bankAcctTrnRec.setOriginatorsBank(values.get(ORIGINATORS_BANK));
			bankAcctTrnRec.setInstructingBank(values.get(INSTRUCTING_BANK));
			bankAcctTrnRec.setOriginatorToBeneficiaryInfo(values.get(ORIGINATOR_TO_BENEFICIARY_INFO));
			bankAcctTrnRec.setAmount(values.get(AMOUNT));
			bankAcctTrnRec.setAcceptanceTimestamp(values.get(ACCEPTANCE_TIMESTAMP));
			bankAcctTrnRec.setOmadInfo(values.get(OMAD_FIELDS));
			bankAcctTrnRec.setImadInfo(values.get(IMAD));
			bankAcctTrnRec.setCharges(values.get(CHARGES));
			bankAcctTrnRec.setInstructedAmount(values.get(INSTRUCTED_AMOUNT));
			BankSvcRs svcRs = new BankSvcRs();
			svcRs.setStatus(new Status());
			svcRs.setRqUID(RQUID_PREFIX + values.get(SENDING_BANK_REFERENCE));
			DepAcctTrnInqRs depAcctTrnInqRs = new DepAcctTrnInqRs();
			depAcctTrnInqRs.setRqUID(svcRs.getRqUID());
			CustId custId = new CustId();
			custId.setCustPermId("BTS2_ING");
			depAcctTrnInqRs.setCustId(custId);
			DepAcctId depAcctId = new DepAcctId();
			depAcctId.setAcctId("1850554666");
			BankInfo bankInfo = new BankInfo();
			bankInfo.setBankId(transactionFlat.getAbaRoutingNumber());
			depAcctId.setBankInfo(bankInfo);
			depAcctTrnInqRs.setDepAcctId(depAcctId);
			DepAcctTrnRec depAcctTrnRec = new DepAcctTrnRec(bankAcctTrnRec);
			CurAmt curAmt = new CurAmt();
			curAmt.setAmt(transactionFlat.getTransactionAmount());
			curAmt.setCurCode("USD");
			depAcctTrnRec.getBankAcctTrnRec().setCurAmt(curAmt);
			depAcctTrnInqRs.setDepAcctTrnRec(depAcctTrnRec);
			svcRs.setDepAcctTrnInqRs(depAcctTrnInqRs);
			bankSvcRs.add(svcRs);
		}
		CMA cma = new CMA();
		cma.setBankSvcRs(bankSvcRs);
		try {
			XStreamMarshaller xStreamMarshaller = new XStreamMarshaller();
			xStreamMarshaller.setAutodetectAnnotations(true);
			StringWriter stringWriter = new StringWriter();
			stringWriter.write(DocumentHelper.createDocument().asXML());
			xStreamMarshaller.marshal(cma, new StreamResult(stringWriter));
			System.out.println(stringWriter.toString());
			System.out.println("Generation Complete");
			System.out.println(System.getProperty("java.version"));
		} catch (Exception e) {
			System.out.println("Error file generation");
		}
	}
}
