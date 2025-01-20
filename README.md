# Currency Exchanger

Currency Exchanger is a simple Java application that allows users to convert between different currencies using exchange rates provided by a third-party API.

## Features
- Convert ARS to USD
- Convert USD to ARS
- Convert BRL to USD
- Convert USD to BRL
- Convert COP to USD
- Convert USD to COP

## Requirements
- Java 8 or higher
- Internet connection (to fetch exchange rates)

## Installation
1. Clone the repository:
   ```
   git clone https://github.com/7aviel/exchanger.git
Navigate to the project directory:
	```
		cd CurrencyExchanger
	```
Build the project using your preferred build tool (e.g., Maven, Gradle).

## Usage
Run the MainMenu class to start the application.

Follow the on-screen instructions to select the currency conversion you want to perform.

Enter the amount you want to convert.

The application will display the converted amount based on the current exchange rate.

## Project Structure
org.oracleone.service.MainMenu: The main class that handles user interaction and currency conversion logic.

org.oracleone.model.ExchangeRecord: A model class representing exchange rate information.

org.oracleone.service.Connection: A utility class for making HTTP requests to the exchange rate API.

## Third-Party Libraries
- [Gson](https://github.com/google/gson): For JSON parsing.
- [ExchangeRate-API](https://www.exchangerate-api.com/?form=MG0AV3): For fetching real-time exchange rates.

## Exchange Rates API
The application uses the ExchangeRate-API to fetch real-time exchange rates. You can configure the base and target currencies in the getExchangeRecordEntity method in the MainMenu class.

```java
private ExchangeRecord getExchangeRecordEntity(String baseCurrency, String targetCurrency) {
       String json = connection.getConnection("https://v6.exchangerate-api.com/v6/your-api-key/pair/" + baseCurrency + "/" + targetCurrency);
   return gson.fromJson(json, ExchangeRecord.class);
}
```
## Contact
If you have any questions or suggestions, feel free to reach out at vilcheariel1@gmail.com
