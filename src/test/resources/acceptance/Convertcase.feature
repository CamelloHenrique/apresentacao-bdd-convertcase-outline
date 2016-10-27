Feature: Convertcase
	
	Scenario Outline: converter o "case" de uma palavra
		
	Given Eu abri o site "<site>"
	
	When Eu digitar "<input>" no painel "content"
	
	And E clicar em "<botao>"
	
	Then "<input>" deve ser convertido para "<output>"
	
	Examples:
	
	| site   					 | botao            | input					    | output			    |  
	| https://convertcase.net/   | Capitalized Case | henrique cota camello     | Henrique Cota Camello |
	| https://convertcase.net/   | lower case       | HENRIQUE                  | henrique			    |
	| https://convertcase.net/   | UPPER CASE       | henrique                  | HENRIQUE              |
	