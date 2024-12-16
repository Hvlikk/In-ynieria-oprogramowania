package System.ViewLayer;

import System.*;
import System.MainPresenter.IOrderFacade;
import System.MainPresenter.OrderFacade;
import System.OrdersApiModel.OrdersApiModel.DeviceModel;
import System.OrdersApiModel.OrdersApiModel.IDeviceModel;
import System.OrdersApiModel.OrdersApiModel.IOrderModel;
import System.OrdersApiModel.OrdersApiModel.OrderModel;
import System.StorageModel.StorageModel.ItemModel;
import System.StoragePrezenter.StoragePrezenter.InventoryControler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class View {

	private IInventoryClient inventoryClient = new InventoryControler();
	private IOrderFacade orderFacade = new OrderFacade();
	private ArrayList<ItemModel> backupMock = new ArrayList<>();
	private IDeviceModel mockDeviceModel = new DeviceModel();
	private IOrderModel mockOrderModel = new OrderModel();
	private int mockWorkerId = 0;
	private int mockClientId = 0;

	public void ExecuteUseCases() throws IOException {
		System.out.printf("\n\nWykonaj PU: \n");
		System.out.printf("PU4 stworzenie zlecenia naprawy bez przypisania serwisanta:          PU4a\n");
		System.out.printf("PU4 stworzenie zlecenia naprawy z przypisaniem serwisanta:          PU4b\n");
		System.out.printf("PU21 przypisanie zlecenia serwisantowi:                              b\n");
		System.out.printf("PU20 aktualizacja dostepnosci serwisanta:                            c\n");
		System.out.printf("Wykonaj PU: \n");
		System.out.printf("PU1: Podglad stanu calego magazynu:              A\n");
		System.out.printf("PU2: Podglad stanu magazynowego wybranej czesci: B\n");
		System.out.printf("PU9: Aktualizacja stanu magazynu:                C\n");
		System.out.printf("PU10: Przywrocenie ostatniej wersji magazynu:    D\n");
		System.out.printf("PU1E: Naloz filtr:                               E\n");

		Scanner myObj = new Scanner(System.in);

		String result = myObj.nextLine();

		switch (result) {
			case "PU4a": {
				orderFacade.CreateOrder(mockDeviceModel,mockOrderModel,mockWorkerId,mockClientId);
				break;
			}
			case "PU4b": {
				orderFacade.CreateOrder(mockDeviceModel,mockOrderModel,-1,mockClientId);
				break;
			}
			case "A": {
				ArrayList<ItemModel> items = new ArrayList<>();
				items = inventoryClient.ShowAll();
				if (items.size() > 0){
					for (int i = 0; i < items.size(); i++)
					{
						System.out.println("Part ID:"  + items.get(i).GetPartID(items.get(i)) + " Quantity : " + items.get(i).GetQuantity(items.get(i)));
					}
				}
				else {
					System.out.println("Magazyn jest pusty.");
				}

				break;
			}
			case "B":{
				System.out.println("Podaj part ID czesci, ktora chcesz wyswietlic!");
				ArrayList<ItemModel> items = new ArrayList<>();
				int selectedPartID = myObj.nextInt();
				items = inventoryClient.ShowPart(selectedPartID);

				if (items.size() > 0){
					for (int i = 0; i < items.size(); i++)
					{
						System.out.println("Part ID:"  + items.get(i).GetPartID(items.get(i)) + " Quantity : " + items.get(i).GetQuantity(items.get(i)));
					}
				}
				else {
					System.out.println("Nie ma takiej czesci na magazynie.");
				}

				break;
			}
			case "C": {
				boolean isAppending = true;
				boolean isOk;
				ArrayList<ItemModel> items = new ArrayList<>();
				int partID, quant;
				String choice;

				System.out.println("TRYB WPROWADZANIA DANYCH!");
				while (isAppending) {
					System.out.print("Podaj partID: ");
					partID = myObj.nextInt();

					System.out.print("Podaj ilosc: ");
					quant = myObj.nextInt();

					items.add(new ItemModel(partID, quant));

					// Oczyszczenie bufora przed użyciem nextLine()
					myObj.nextLine();

					System.out.print("Czy wprowadzasz dalej? Y/N: ");
					choice = myObj.nextLine().trim(); // trim() usunie białe znaki, np. spacje

					if (choice.equalsIgnoreCase("N")) { // użyj equalsIgnoreCase dla porównania
						isAppending = false;
					}
				}

				isOk = inventoryClient.UpdateData(items);
				if (isOk)
					System.out.println("Update wykonany poprawnie!");
				else
					System.out.println("Blad w wykonywaniu update!");
				break;
			}
			case "D": {
				createBackupMock();
				boolean isSuccess = inventoryClient.RecoverBackup(backupMock);
				if (isSuccess) {
					System.out.println("Backup wgrany prawidlowo!");
				} else {
					System.out.println("Blad podczas przywracania bazy danych!");
				}
				break;
			}
			case "E": {
				ArrayList<ItemModel> filteredItems = new ArrayList<>();
				filteredItems = inventoryClient.ApplyFilter();
				System.out.println("Odfiltrowane przedmioty: ");
				for(int i = 0 ; i < filteredItems.size(); i++){
					System.out.println("Part ID: " + filteredItems.get(i).GetPartID(filteredItems.get(i)) + " Quantity : " + filteredItems.get(i).GetQuantity(filteredItems.get(i)));
				}
				break;
			}
			case "d":{
				break;
			}
			case "e":{

			}
			case "f":{

			}
			case "g":{

			}
			default: {
				return;
			}
		}
	}

	public void createBackupMock(){
		backupMock.add(new ItemModel(1,1));
		backupMock.add(new ItemModel(2,2));
		backupMock.add(new ItemModel(3,3));
		backupMock.add(new ItemModel(4,4));
		backupMock.add(new ItemModel(5,5));
		backupMock.add(new ItemModel(6,6));
	}
}