<html>
	<head>
		<meta http-equiv="Content-type" content="text/html; charset=utf-8">
		<title>jQuery datePicker simple datePickerStartEnd demo</title>
		
		<!-- firebug lite -->
		<script type="text/javascript" src="js/firebug/firebug.js"></script>

        <!-- jQuery -->

		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
        
        <!-- required plugins -->
		<script type="text/javascript" src="js/jquery/scripts/date.js"></script>
		<!--[if IE]><script type="text/javascript" src="scripts/jquery.bgiframe.min.js"></script><![endif]-->
        
        <!-- jquery.datePicker.js -->
		<script type="text/javascript" src="js/jquery/scripts/jquery.datePicker.js"></script>
        
        <!-- datePicker required styles -->

		<link rel="stylesheet" type="text/css" media="screen" href="css/datePicker.css">
		
        <!-- page specific styles -->
		<link rel="stylesheet" type="text/css" media="screen" href="css/demo.css">
        
        <!-- page specific scripts -->
		<script type="text/javascript" charset="utf-8">

		
		
			$(function()
            {
				$('.date-pick').datePicker(
						{
							startDate: '01/04/2010',
							endDate: (new Date()).asString()
						}

				);
				$('#start-date').bind(
					'dpClosed',
					function(e, selectedDates)
					{
						var d = selectedDates[0];
						if (d) {
							d = new Date(d);
							
							$('#end-date').dpSetStartDate(d.addDays(1).asString());
						}
					}
				);
				$('#end-date').bind(
					'dpClosed',
					function(e, selectedDates)
					{
						var d = selectedDates[0];
						if (d) {
							d = new Date(d);
							$('#start-date').dpSetEndDate(d.addDays(-1).asString());
						}
					}
				);
            });
		</script>
		
	</head>
	<body>
       

         
          
			<form name="chooseDateForm" id="chooseDateForm" action="index.jsp">
				<table border="1">
					<tr>
						<td>
							Start date:
						</td>
                        <td>
                          
                         	 <label for="start-date">  </label>
                          
							<input name="start-date" id="start-date" class="date-pick" />
						
						</td>
						<td>
							 End date:
						</td>
						<td>
							<input name="end-date" id="end-date" class="date-pick" />
						</td>
						<td>
							<input type="submit" name=""submit" value="submit"/>
						</td>
						
					</tr>
				</table>	
			</form>
			
			
        
	</body>
</html>