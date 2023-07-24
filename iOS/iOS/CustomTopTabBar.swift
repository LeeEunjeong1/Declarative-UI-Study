//
//  CustomTopTabBar.swift
//  iOS
//
//  Created by Financial CB on 2023/07/11.
//

import SwiftUI

struct CustomTopTabBar: View {
    
    private var tabBarItems: [String] = ["서머 바캉스", "추천", "랭킹", "스타일", "세일", "뷰티", "이벤트"]
	@Binding var tabIndex: Int
	
    var body: some View {
//        ScrollView(.horizontal) {
//			TabBarButton(text: "서머 바캉스", isSelected: .constant(tabIndex == 0))
//				.onTapGesture { onButtonTapped(index: 0) }
//			TabBarButton(text: "추천", isSelected: .constant(tabIndex == 1))
//				.onTapGesture { onButtonTapped(index: 1) }
//			TabBarButton(text: "랭킹", isSelected: .constant(tabIndex == 2))
//				.onTapGesture { onButtonTapped(index: 2) }
//			TabBarButton(text: "스타일", isSelected: .constant(tabIndex == 3))
//				.onTapGesture { onButtonTapped(index: 3) }
//			TabBarButton(text: "세일", isSelected: .constant(tabIndex == 4))
//				.onTapGesture { onButtonTapped(index: 4) }
//			Spacer()
//        }
        
        TabView {
            ForEach(tabBarItems.indices, id: \.self) { index in
                Text(tabBarItems[index])
                    .onTapGesture {
                        <#code#>
                    }
            }
        }
    }
}

//struct CustomTopTabBar_Previews: PreviewProvider {
//    static var previews: some View {
//        CustomTopTabBar()
//    }
//}
