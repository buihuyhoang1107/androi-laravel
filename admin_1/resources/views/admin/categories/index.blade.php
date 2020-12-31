@extends('layouts.dashboard')
@section('content')
	<div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0 text-dark">Categories</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="{{route('home')}}">Dashboard</a></li>
              <li class="breadcrumb-item active">Categories</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>    

    <section class="content">
    	<div class="container-fluid">
    		<p>
    			<a href="{{route('home.categories.create')}}" class="btn btn-primary">Add new categories</a>
    		</p>

    		<table class="table table-bordered table-striped">
    			<tr>
    				<th>ID</th>
    				<th>Tên</th>
					<th>Hình ảnh</th>
    				<th>Action</th>
    			</tr>
    			@foreach($categories as $value)
    			<tr>
    				<td>{{$value->id}}</td>
    				<td>{{$value->title}}</td>
					<td><img src="{{asset('storage/category/'.$value->hinhanh)}}" style="width:150px"></td>
    				<td><a href="{{route('home.categories.edit',$value->id)}}" class="btn btn-success">Edit</a>
						 <a href="javascript:void(0)" onclick="$(this).parent().find('form').submit()" class="btn btn-secondary">Delete</a>
						 <form action="{{route('home.categories.destroy',$value->id )}}" method="post">
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