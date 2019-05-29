package retailBanking.TC;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;

import core.util.Utils;
import retailBanking.PO.PO_Common;
import retailBanking.PO.PO_Login;
import retailBanking.PO.PO_TransferFunds;

@Listeners(ExtentITestListenerClassAdapter.class)
public class SmokeTest {
	
		@Parameters({"url","browser"})
		@Test(priority=1)
		public void t_01_check_login(String url,String browserType) {
			try {
				//String url = "http://zero.webappsecurity.com/login.html";
				WebDriver driver = Utils.InvokeBrowser(browserType, url);

				//Init Page Object
				
				PO_Login login = PageFactory.initElements(driver, PO_Login.class);
				login.KW_LoginInToApplication("username", "password");
				Utils.WriteLogs("pass","Test Case completed");
				
			}catch(Exception e) {
				Utils.WriteLogs("fail","Test failed");
				Assert.assertFalse(false);
			}

		}
		@Parameters({"url","browser"})
		@Test(priority=2)
		public void t_02_check_transfer_funds(String url,String browserType)  {
			WebDriver driver = Utils.InvokeBrowser(browserType, url);
			//Init Page Object
			PO_Login PO_Login = PageFactory.initElements(driver, PO_Login.class);
			PO_Login.KW_LoginInToApplication("username", "password");
			
			//Click on Transfer Funds
			PO_Common PO_Common = PageFactory.initElements(driver, PO_Common.class);
			PO_Common.ClickOnTransferFunds();
			
			//Transfer Funds
			PO_TransferFunds PO_TransferFunds = PageFactory.initElements(driver, PO_TransferFunds.class);
			String from = "1";
			String to = "2";
			String ammount = "10";
			String descp = "test";
			
			PO_TransferFunds.KW_FillTransferFundsPageAndSubmit(from, to, ammount, descp);
			Utils.WriteLogs("pass","Test Case completed");
			
		}
		

}

