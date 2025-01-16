package System.ViewLayer;

import System.*;
import System.MainPresenter.IOrderFacade;
import System.MainPresenter.IWorkerFacade;
import System.MainPresenter.OrderFacade;
import System.MainPresenter.WorkerFacade;
import System.OrdersApiModel.OrdersApiModel.DeviceModel;
import System.OrdersApiModel.OrdersApiModel.IDeviceModel;
import System.OrdersApiModel.OrdersApiModel.IOrderModel;
import System.OrdersApiModel.OrdersApiModel.OrderModel;
import System.StorageModel.StorageModel.ItemModel;
import System.StoragePrezenter.StoragePrezenter.InventoryControler;
import System.WorkerApiModelLayer.WorkersApiModel.AvailabilityModel;
import System.WorkerApiModelLayer.WorkersApiModel.IAvailabilityModel;
import System.WorkerApiModelLayer.WorkersApiModel.IWorkerModel;
import System.WorkerApiModelLayer.WorkersApiModel.WorkerModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class View {

	private IInventoryClient inventoryClient = new InventoryControler();
	private IOrderFacade orderFacade = new OrderFacade();
	private IWorkerFacade workerFacade = new WorkerFacade();

	private ArrayList<ItemModel> backupMock = new ArrayList<>();
	private IDeviceModel mockDeviceModel = new DeviceModel();
	private IOrderModel mockOrderModel = new OrderModel();
	private IAvailabilityModel mockAvailabilityModel = new AvailabilityModel();
	private IWorkerModel mockWorkerModel = new WorkerModel();

	private int mockWorkerId = 0;
	private int mockClientId = 0;

	public void ExecuteUseCases() throws IOException {
		System.out.printf("\n\nWykonaj PU: \n");
		System.out.printf("PU4 stworzenie zlecenia naprawy bez przypisania serwisanta:          PU4a\n");
		System.out.printf("PU4 stworzenie zlecenia naprawy z przypisaniem serwisanta:           PU4b\n");
		System.out.printf("PU21 przypisanie zlecenia serwisantowi:                              PU21\n");
		System.out.printf("PU20 aktualizacja dostepnosci serwisanta:                            PU20\n");
		System.out.printf("PU1: Podglad stanu calego magazynu:              					 PU1\n");
		System.out.printf("PU2: Podglad stanu magazynowego wybranej czesci: 					 PU2\n");
		System.out.printf("PU9: Aktualizacja stanu magazynu:                					 PU9\n");
		System.out.printf("PU10: Przywrocenie ostatniej wersji magazynu:    					 PU10\n");
		System.out.printf("PU1E: Naloz filtr:                               					 PU1E\n");

		Scanner myObj = new Scanner(System.in);

		String result = myObj.nextLine();

		switch (result) {
			case "PU4b": {
				orderFacade.CreateOrder(mockDeviceModel,mockOrderModel,mockWorkerId,mockClientId);
				break;
			}
			case "PU4a": {
				orderFacade.CreateOrder(mockDeviceModel,mockOrderModel,-1,mockClientId);
				break;
			}
			case "PU20": {
				workerFacade.ChangeAvailability(mockWorkerModel,mockAvailabilityModel);
				break;
			}
			case "PU21": {
				orderFacade.ChangeWorkerForOrder(mockWorkerModel,mockOrderModel);
				break;
			}
			case "PU1": {
				ArrayList<ItemModel> items = new ArrayList<>();
				items = inventoryClient.ShowAll();
				if (items.size() > 0){
					for (int i = 0; i < items.size(); i++)
					{
						System.out.println("Part ID:"  + items.get(i).GetPartID() + " Quantity : " + items.get(i).GetQuantity());
					}
				}
				else {
					System.out.println("Magazyn jest pusty.");
				}

				break;
			}
			case "PU2":{
				System.out.println("Podaj part ID czesci, ktora chcesz wyswietlic!");
				ArrayList<ItemModel> items = new ArrayList<>();
				int selectedPartID = myObj.nextInt();
				items = inventoryClient.ShowPart(selectedPartID);

				if (items.size() > 0){
					for (int i = 0; i < items.size(); i++)
					{
						System.out.println("Part ID:"  + items.get(i).GetPartID() + " Quantity : " + items.get(i).GetQuantity());
					}
				}
				else {
					System.out.println("Nie ma takiej czesci na magazynie.");
				}

				break;
			}
			case "PU9": {
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
			case "PU10": {
				createBackupMock();
				boolean isSuccess = inventoryClient.RecoverBackup(backupMock);

				for (int i = 0; i < backupMock.size(); i++) {
					System.out.println("ID" + backupMock.get(i).GetPartID() + "Quant" + backupMock.get(i).GetQuantity());
				}
				if (isSuccess) {
					System.out.println("Backup wgrany prawidlowo!");
				} else {
					System.out.println("Blad podczas przywracania bazy danych!");
				}
				break;
			}
			case "PU1E": {
				int chosenFilter, filterNumber;
				System.out.printf("partID > partIDFilter         | 1\n");
				System.out.printf("partID < partIDFilter         | 2\n");
				System.out.printf("quantity > quantityFilter     | 3\n");
				System.out.printf("quantity < quantityFilter     | 4\n");
				Scanner scanner = new Scanner(System.in);
				System.out.printf("Wybierz filtr: \n");
				chosenFilter = scanner.nextInt();
				System.out.printf("Podaj wartosc filtra: \n");
				filterNumber = scanner.nextInt();
				ArrayList<ItemModel> filteredItems = new ArrayList<>();
				filteredItems = inventoryClient.ApplyFilter(chosenFilter, filterNumber);
				System.out.println("Odfiltrowane przedmioty: ");
				for(int i = 0 ; i < filteredItems.size(); i++){
					System.out.println("Part ID: " + filteredItems.get(i).GetPartID() + " Quantity : " + filteredItems.get(i).GetQuantity());
				}
				break;
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