----------------------
Optional-创建		  |
----------------------
	1,声明一个空的 Optional
		Optional<Car> optCar = Optional.empty();
	
	2,根据一个值创建非空的 Optional
		Optional<Car> optCar = Optional.of(car);
		* 如果 car 值为 null,那么会抛出 空指针异常
	
	3,可以接受 null 的 Optional
		Optional<Car> optCar = Optional.ofNullable(car);

----------------------
Optional-方法		  |
----------------------
	isPresent();
		* 如果有值返回 true,源码 return value != null;

	ifPresent(Consumer<? super T> consumer);
		* 如果值不为 null,那么把 value 传递给 consumer 执行

	get();
		* 获取值,如果值不存在则抛出 NoSuchElement 异常

	orElse(T data);
		* 会在值存在的时候返回值,如果返回一个默认值(形参)
	
	orElseGet(Supplier<? extends T> other);
		* 会在值存在的时候返回值,如果值不存在则调用 other Lambda的的 get方法返回默认值
	
	orElseThrow();
		* 会在值存在的时候返回值,如果不存在则抛出异常
	
	map(Function function);
		* 如果有值,就调用 function 进行处理
		* 没有值,就返回 Optional.empty();
	
	flatMap(Function function);
		* 跟map差不多,要求返回值必须是 Optional
	

	


	

	