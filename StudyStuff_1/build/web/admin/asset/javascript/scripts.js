// $('.open_pincode_modal').click(function(){ 
// 	$('#h_city_code').val($(this).data('citycode'));
// 	$('#pincode_modal').modal('toggle');
// });


/*var i = 1;
$('.add_row').click(function(){ 
	//alert("hello");
	var html = '<div class="row" id="row_'+(i)+'"><div class="col-sm-5 col-md-5 col-lg-5"><input type="text" class="form-control" placeholder="Enter Area Name" name="area[]"></div><div class="col-sm-5 col-md-5 col-lg-5"><input type="text" class="form-control" placeholder="Enter Role Name" name="zipCode[]"></div><div class="col-sm-2 col-md-2 col-lg-2"><a href="javascript:remove_row('+(i++)+');" class="btn btn-danger"><i class="fa fa-trash"></i></a></div></div>';
	$('.rows').append(html);
});

function remove_row(row_id){
	$('#row_'+row_id).remove();
}
*/

var i = 1;
$('.add_sub').click(function(){ 
	var html = '<div class="row" id="row_'+(i)+'"><div class="col-sm-12 col-md-4 col-lg-4"><label>Zone Name</label><input type="text" class="form-control" placeholder="Enter Sub-Zone Name" name="SubZoneName"></div>';
		$('.rows').append(html);
});

function remove_row(row_id){
	$('#row_'+row_id).remove();
}
// var i=1; 
// $('.addCF').click(function(){ 
// 	//var html = '<div class="row" id="row_'+(i)+'"><div class="col-sm-12 col-md-4 col-lg-4"><label>Zone Name</label><input type="text" class="form-control" placeholder="Enter Sub-Zone Name" name="SubZoneName"></div>;
// 	var html='<tr id="newrow_'+(i)+'"><td style="text-align:center !important;"><span class="xyza"></span></td><td><input type="text" name="cp_name"></td><td><input type="text" name="cp_designation"></td><td><input type="text" name="cp_mobile"></td><td><input type="text" name="cp_email"></td></tr>';
// 	$('#product_table_body').append(html);
// });
// function remove_row(row_id){
// 	$('#product_table_body'+row_id).remove();
// }
 