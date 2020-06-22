<if>
	# 不多解释

<choose>
	<when></when>
	<otherwise> </otherwise>
</choose>
	# 不多解释

<where>
</where>
	# where 元素知道只有在一个以上的(子标签中)if条件有值的情况下才去插入"WHERE"子句。
	# 而且，若最后的内容是"AND"或"OR"开头的，where 元素也知道如何将他们去除。
	# 如果 where 元素没有按正常套路出牌，我们还是可以通过自定义 trim 元素来定制我们想要的功能。
	# 比如，和 where 元素等价的自定义 trim 元素为：
		<trim prefix="WHERE" prefixOverrides="AND |OR ">
		  ... 
		</trim>
<set>
	# 同 where,会自动的在最前面添加SET语句,并且删除最后一个','
	# 若你对等价的自定义 trim 元素的样子感兴趣，那这就应该是它的真面目：
		<trim prefix="SET" suffixOverrides=",">
		  ...
		</trim>

<trim>
	# 属性
		prefixOverrides 
			# 属性会忽略通过管道分隔的文本序列（注意此例中的空格也是必要的）。
			# 它带来的结果就是所有在 prefixOverrides 属性中指定的内容将被移除，并且插入 prefix 属性中指定的内容。
			# 忽略前溢出的分隔符
		
		suffixOverrides
			# 忽略最后的溢出的分隔符
		
		prefix
			# 开始的时候添加
		
		suffix
			# 结束的时候添加

	# 插入案例
		<trim prefix=" (" suffix=")" suffixOverrides=",">
			<if test="id != null">id,</if>
		</trim>
		<trim prefix=" VALUES(" suffix=")" suffixOverrides=",">
			<if test="id != null">#{id},</if>
		</trim>

