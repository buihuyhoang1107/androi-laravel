@extends('layouts.dashboard')
@section('content')
	<div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0 text-dark">Vùng miền</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="{{route('home')}}">Dashboard</a></li>
              <li class="breadcrumb-item active">Vùng miền</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>    

    <section class="content">
    	<div class="container-fluid">
    		<p>
    			<a href="{{route('home.vungmien.create')}}" class="btn btn-primary">Thêm mới vùng miền</a>
    		</p>

    		<table class="table table-bordered table-striped">
    			<tr>
    				<th>ID</th>
    				<th>Titel</th>
    				<th>Action</th>
    			</tr>
    			@foreach($vungmien as $value)
    			<tr>
    				<td>{{$value->id}}</td>
    				<td>{{$value->ten_vungmien}}</td>
    				<td><a href="{{route('home.vungmien.edit',$value->id)}}" class="btn btn-success">Edit</a>
						 <a href="javascript:void(0)" onclick="$(this).parent().find('form').submit()" class="btn btn-secondary">Delete</a>
						 <form action="{{route('home.vungmien.destroy',$value->id )}}" method="post">
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