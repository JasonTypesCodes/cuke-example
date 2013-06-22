$(document).ready(function() {
  
  inputFormSubmitUpdatesTable();
  
  $('#result_table').dataTable();  
});

function inputFormSubmitUpdatesTable(){
  $('input#submit_button').click(function(){
    var firstName = $('input[name="first_name"]').val();
    var lastName = $('input[name="last_name"]').val();
    var age = $('input[name="age"]').val();

    addPersonToTable(firstName, lastName, age);
  });
}

function addPersonToTable(firstName, lastName, age){
  $('#result_table').dataTable().fnAddData([
    firstName,
    lastName,
    age
  ]);
}
