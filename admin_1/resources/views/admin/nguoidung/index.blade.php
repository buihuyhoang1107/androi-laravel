@extends('layouts.dashboard')
@section('content')
	<div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0 text-dark">Người dùng</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="{{route('home')}}">Dashboard</a></li>
              <li class="breadcrumb-item active">Người dùng</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>    

    <section class="content">
    	<div class="container-fluid">
    		<p>
    			<a href="{{route('home.nguoidung.create')}}" class="btn btn-primary">Thêm mới người dùng</a>
    		</p>

    		<table class="table table-bordered table-striped">
    			<tr>
    				<th>ID</th>
    				<th>Tên</th>
					<th>Gmail</th>
                    <th>Phân quyền</th>
                    <th>Khóa</th>
    				<th>Action</th>
    			</tr>
    			@foreach($nguoidung as $value)
    			<tr>
    				<td>{{$value->id}}</td>	
    				<td>{{$value->ten}}</td>
					<td>{{$value->gmail}}</td>
                    <td>{{($value->phanquyen==1)?"admin":"user"}}</td>
                    <td><input type="submit" value="{{($value->action==1)?"Mở Khóa":"Khóa"}}" id="{{$value->id}}" type="button" 
					class="{{($value->action==0)?"btn-action btn btn-outline-danger":"btn-action btn btn-outline-success"}}"/></td>
    				<td><a href="{{route('home.nguoidung.edit',$value->id)}}" class="btn btn-success">Edit</a>
						 <a href="javascript:void(0)" onclick="$(this).parent().find('form').submit()" class="btn btn-secondary">Delete</a>
						 <form action="{{route('home.nguoidung.destroy',$value->id )}}" method="post">
						 	@method('DELETE')
							 <input type="hidden" name="_token" value="{{csrf_token()}}">
						 </form>
					</td> 
    			</tr>
    			@endforeach
    		</table>
    		
    	</div>
    </section>
@endsection
@section('scripts')
<script language="javascript">
	// function swap(var $id){
	// 	$("#"+$id).attr('class','btn btn-outline-success');
	// }
	
$(".btn-action").on('click',function(e) {
	e.preventDefault();
	var id =($(this).attr("id"));
    $.ajax({
		type: "GET",
		dataType: "json",
		url: 'https://coderthanhson.000webhostapp.com/api/nguoidungs/swap/'+id,
        success: function(data) {
			console.log(data);
			$(".btn-action#"+data.id).val((data.action==true)?'Mở Khóa':'Khóa');
			$(".btn-action#"+data.id).attr('class',(data.action==true)?'btn-action btn btn-outline-success':'btn-action btn btn-outline-danger');
        },
        error: function() {
            alert('Lỗi chương trình');
        }
    });
})
</script>
@endsection