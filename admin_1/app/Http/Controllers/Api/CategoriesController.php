<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Category;
use Validator;
class CategoriesController extends Controller
{
    public function Category(){
        return response()->json(Category::get(),200);
    }
    public function CategoryById($id){
        $category=Category::find($id);
        if(is_null($category)){
            return response()->json(["messge"=>"Record not found"],404);
        }
        return response()->json($category,200);
    }
    public function CategorySave(Request $request){
        $rule=['title'=>'required|min:3'];
        $validator=Validator::make($request->all(),$rule);
        if($validator->fails()){
            return response()->json($validator->errors(),400);
        }
        $category = Category::create($request->all());
        return response()->json($category,201);
    }
    public function CategoryUpdate(Request $request,$id){
        $category=Category::find($id);
        if(is_null($category)){                                                                          
            return response()->json(["messge"=>"Record not found"],404);
        }
        $category->update($request->all());
        return response()->json($category,200);
    }
    public function CategoryDelete(Request $request,$id){
        $category=Category::find($id);
        if(is_null($category)){                                                                          
            return response()->json(["messge"=>"Record not found"],404);
        }
        $category->delete();
        return response()->json(null,204);
    }
    
}
