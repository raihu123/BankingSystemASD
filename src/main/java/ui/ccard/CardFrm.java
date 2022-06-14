package ui.ccard;

import ccard.controllers.CreditAccountController;
import framework.fintech.models.Account;
import lombok.Getter;
import lombok.Setter;
import ui.bank.AccountButton;
import ui.bank.CardBtnActions;
import ui.bank.MainFrame;

import javax.swing.*;
import java.util.Arrays;
import java.util.Collection;

@Getter
@Setter
public class CardFrm extends MainFrame {
    private CreditAccountController creditAccountController;
    private CardBtnActions btnActions;
    private String expDate;
    private String ccNumber;
    private CardFrm cardFrame;

    public CardFrm() {
        setFrame(this);
        btnActions = new CardBtnActions(new CreditAccountController(), this);
        overview("Credit-card processing Application.", getTableColumnNames(), getButtons());
    }

    public static void main(String[] args) {
        try {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) { }
            (new CardFrm()).setVisible(true);
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }
    }

    @Override
    public void updateTable(Account account) {
        if (isNewAccount()) {
            changeTableContent(account.getCustomer().getName(), account.getId(), getExpDate(), getAccountType(), Double.toString(account.getBalance()));
            setNewAccount(false);
        }
    }

    private Collection<String> getTableColumnNames() {
        return Arrays.asList("Name", "CC number", "Exp date", "Type", "Balance");
    }

    private Collection<JButton> getButtons() {
        return Arrays.asList(
                new AccountButton("Add Credit-card account", getBtnActions().addCreditCardAccount, 24, 20, 192, 33),
                new AccountButton("Generate Monthly bills", getBtnActions().generateBill, 240, 20, 192, 33),
                new AccountButton("Deposit", getBtnActions().deposit, 468, 104, 96, 33),
                new AccountButton("Charge", getBtnActions().withdraw, 468, 20, 106, 33),
                new AccountButton("Exit", getBtnActions().exitWindow, 468, 150, 96, 33)
        );
    }

	public CreditAccountController getCreditAccountController() {
		return creditAccountController;
	}

	public void setCreditAccountController(CreditAccountController creditAccountController) {
		this.creditAccountController = creditAccountController;
	}

	public CardBtnActions getBtnActions() {
		return btnActions;
	}

	public void setBtnActions(CardBtnActions btnActions) {
		this.btnActions = btnActions;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public String getCcNumber() {
		return ccNumber;
	}

	public void setCcNumber(String ccNumber) {
		this.ccNumber = ccNumber;
	}

	public CardFrm getCardFrame() {
		return cardFrame;
	}

	public void setCardFrame(CardFrm cardFrame) {
		this.cardFrame = cardFrame;
	}
    
    
}
