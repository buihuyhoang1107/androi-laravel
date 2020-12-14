@extends('layouts.dashboard')
@section('content')
	<div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0 text-dark">Bài viết</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="{{route('home')}}">Dashboard</a></li>
              <li class="breadcrumb-item active">Bài viết</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>    

    <section class="content">
    	<div class="container-fluid">
    		<p>
    			<a href="{{route('home.baiviet.create')}}" class="btn btn-primary">Thêm mới bài viết</a>
    		</p>

    		<table class="table table-bordered table-striped">
    			<tr>
    				<th>ID</th>
    				<th>Ten</th>
					<th>ChuDe</th>
					<th>VungMien</th>
					<th>NguyenLieu</th>
					<th>SoChe</th>
					<th>ThucHien</th>
					<th>CachDung</th>
    				<th>Action</th>
    			</tr>
                @if(count($baiviet))
    			@foreach($baiviet as $value)
    			<tr>
    				<td>{{$value->id}}</td>
					<td>{{$value->ten}}</td>
					<td>{{$value->category->title}}</td>
					<td>{{$value->vungmien_id}}</td>
					<td>{{$value->nguyenlieu}}</td>
					<td>{{$value->soche}}</td>
					<td>{{$value->thuchien}}</td>
					<td>{{$value->cachdung}}</td>
    				<td><a href="{{route('home.baiviet.edit',$value->id)}}" class="btn btn-success">Edit</a>
						 <a href="javascript:void(0)" onclick="$(this).parent().find('form').submit()" class="btn btn-secondary">Delete</a>
						 <form action="{{route('home.baiviet.destroy',$value->id )}}" method="post">
						 	@method('DELETE')
							 <input type="hidden" name="_token" value="{{csrf_token()}}">
						 </form>
					</td> 
    			</tr>
    			@endforeach
                @else
                <tr><td colspan="10">Không tìm thấy bài viết </td></tr>
                @endif
    		</table>
    		
    	</div>
    </section>
@endsection