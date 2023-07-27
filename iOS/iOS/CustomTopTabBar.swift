//
//  CustomTopTabBar.swift
//  iOS
//
//  Created by Financial CB on 2023/07/11.
//

import SwiftUI

struct CustomTopTabBar: View {
    
	@Binding var tabIndex: Int
    
    var body: some View {
        HStack {
            TabBarButton(text: "서머 바캉스", isSelected: .constant(tabIndex == 0))
                .onTapGesture { onButtonTapped(index: 0) }
            TabBarButton(text: "추천", isSelected: .constant(tabIndex == 1))
                .onTapGesture { onButtonTapped(index: 1) }
            TabBarButton(text: "랭킹", isSelected: .constant(tabIndex == 2))
                .onTapGesture { onButtonTapped(index: 2) }
            TabBarButton(text: "스타일", isSelected: .constant(tabIndex == 3))
                .onTapGesture { onButtonTapped(index: 3) }
            TabBarButton(text: "세일", isSelected: .constant(tabIndex == 4))
                .onTapGesture { onButtonTapped(index: 4) }
            Spacer()
        }
    }
    
    private func onButtonTapped(index: Int) {
        withAnimation { tabIndex = index }
    }
}

struct TabBarButton: View {
    let text: String
    @Binding var isSelected: Bool
    
    var body: some View {
        Text(text)
            .fontWeight(isSelected ? .black : .regular)
            .font(.system(size: 16))
            .padding(10)
            .overlay(
                Rectangle()
                    .frame(height: 4)
                    .foregroundColor(isSelected ? .black : .clear),
                alignment: .bottom
            )
    }
}

//struct CustomTopTabBar_Previews: PreviewProvider {
//    static var previews: some View {
//        CustomTopTabBar()
//    }
//}
