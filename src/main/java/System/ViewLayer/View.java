package System.ViewLayer;

import System.*;
import System.StorageModel.StorageModel.ItemModel;
import System.StoragePrezenter.StoragePrezenter.InventoryControler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class View {

	private IInventoryClient inventoryClient = new InventoryControler();
	private ArrayList<ItemModel> backupMock = new ArrayList<>();

	public void ExecuteUseCases() throws IOException {
		System.out.printf("\n\nWykonaj PU: \n");
		System.out.printf("PU4 stworzenie zlecenia naprawy bez przypisania serwisanta:          a\n");
		System.out.printf("PU4 stworzenie zlecenia naprawy z przypisaniem serwisanta:          aa\n");
		System.out.printf("PU21 przypisanie zlecenia serwisantowi:                              b\n");
		System.out.printf("PU20 aktualizacja dostepnosci serwisanta:                            c\n");
		System.out.printf("Wykonaj PU: \n");
		System.out.printf("PU1: Podglad stanu calego magazynu:              A\n");
		System.out.printf("PU2: Podglad stanu magazynowego wybranej czesci: B\n");
		System.out.printf("PU9: Aktualizacja stanu magazynu:                C\n");
		System.out.printf("PU10: Przywrocenie ostatniej wersji magazynu:    D\n");
		System.out.printf("PU1E: Naloz filtr:                               E\n");
		System.out.printf("PU4 stworzenie zlecenia naprawy:                 e1\n");
		System.out.printf("PU21 przypisanie zlecenia serwisantowi:          f1\n");
		System.out.printf("PU20 aktualizacja dostepnosci serwisanta:        g1\n");

		Scanner myObj = new Scanner(System.in);

		String result = myObj.nextLine();

		switch (result) {
			case "a": {
				break;
			}
			case "aa": {
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
			case "c": {
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