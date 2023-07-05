package providerPortalVNSHealthPlans;
import org.testng.annotations.DataProvider;

public class DataProviderTestdata {

	@DataProvider(name="UploadFilePath")
	public Object[][] filePath(){
		return new Object[][] {
			{"C:\\Users\\802072\\git\\ProviderPortalAutomationALM\\providerPortalAutomationALM\\src\\test\\resources\\testDocuments\\ExcelFileUploadTest.xlsx", "ExcelFileUoloadTest"},
			{"C:\\Users\\802072\\git\\ProviderPortalAutomationALM\\providerPortalAutomationALM\\src\\test\\resources\\testDocuments\\JPEGUploadTest.jpg","JPEGUploadTest"},
			{"C:\\Users\\802072\\git\\ProviderPortalAutomationALM\\providerPortalAutomationALM\\src\\test\\resources\\testDocuments\\PDFDocumentUploadTest.pdf","PDFDocumentUploadTest"},
			{"C:\\Users\\802072\\git\\ProviderPortalAutomationALM\\providerPortalAutomationALM\\src\\test\\resources\\testDocuments\\PNGUploadTest.png","PNGUploadTest.png"},
			{"C:\\Users\\802072\\git\\ProviderPortalAutomationALM\\providerPortalAutomationALM\\src\\test\\resources\\testDocuments\\WordDocumentUploadTest.docx","WordDocumentUploadTest"}
		};
	}

}
